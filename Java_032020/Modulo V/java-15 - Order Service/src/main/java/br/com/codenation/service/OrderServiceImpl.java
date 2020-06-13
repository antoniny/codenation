package br.com.codenation.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private static final Double PERCENT_DISCOUNT    = 0.20D;
	private static final Double NO_PERCENT_DISCOUNT = 1.00D;

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {

		return
          items.stream()
				  .mapToDouble(orderItem -> {
				  	Product product = productRepository.findById(orderItem.getProductId()).orElse(null);
				  	if (product != null) {
				  		return (
								( orderItem.getQuantity() * product.getValue() )
								* (product.getIsSale() ? NO_PERCENT_DISCOUNT-PERCENT_DISCOUNT : NO_PERCENT_DISCOUNT )
						);
					}
					return 0;
				   }
				  ).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {

		return ids
				.stream()
				.map(product -> productRepository.findById(product).orElse(null))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders
				.stream()
				.mapToDouble(this::calculateOrderValue)
				.sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {

		return findProductsById(productIds)
				.stream()
				.collect(
						Collectors.groupingBy(Product::getIsSale)
				);
	}

}