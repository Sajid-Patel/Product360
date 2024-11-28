package com.jbk.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.HibernateConfig;
import com.jbk.entity.Product;

public class Operation {
	SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public String addProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct == null) {
				session.save(product);
				session.beginTransaction().commit();
				return "Added Successfully";
			} else {
				return "Product already exist";
			}

		} catch (Exception e) {
			return "something went wrong";
		}

	}

	public String deleteProduct(int productId) {
		Session session = sessionFactory.openSession();

		try {
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {

				session.delete(dbProduct);
				session.beginTransaction().commit();
				return "Product deleted";
			} else {
				return "Product not exists to delete";

			}
		} catch (Exception e) {
			return "Something went wrong";
		}

	}

	public Object getProductById(int productId) {

		Session session = sessionFactory.openSession();

		try {
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {

				return dbProduct;
			} else {
				return "Product not exists";

			}
		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	public String updateProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct != null) {
				session.evict(dbProduct);
				session.update(product);
				session.beginTransaction().commit();
				return "Updated Successfully";
			} else {
				return "Product not exist to update";
			}

		} catch (Exception e) {
			return "something went wrong";
		}

	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getAllProductsByOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getLimitedProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setMaxResults(2);
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getProductsByName(String name) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", name));
			list = criteria.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getProductsGreaterThen(String name) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productName", name));
			list = criteria.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getProductsByIds() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.in("productId", 1, 3));
			list = criteria.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public List<Product> getProductsBetweenIds() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productId", 1, 3));
			list = criteria.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public long productCount() {
		Session session = sessionFactory.openSession();
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				count = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public double productCountMin() {
		Session session = sessionFactory.openSession();
		double count = 0;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.min("productPrice"));
			List<Double> list = criteria.list();
			if (!list.isEmpty()) {
				count = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<Product> queryEg1() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			String hql = "FROM Product";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
