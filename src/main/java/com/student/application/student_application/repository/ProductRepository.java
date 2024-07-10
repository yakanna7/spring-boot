package com.student.application.student_application.repository;


import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MyProduct> findProductsByFilter(ProductFilter filter) {
        StringBuilder sql = new StringBuilder("SELECT * FROM my_products WHERE 1=1");

        if (filter.getCategory() != null) {
            sql.append(" AND category = ?");
        }
        if (filter.getName() != null) {
            sql.append(" AND product_name LIKE ?");
        }
        if (filter.getMinCost() != null && filter.getMaxCost() != null) {
            sql.append(" AND cost BETWEEN ? AND ?");
        }
        if (filter.getColor() != null) {
            sql.append(" AND color = ?");
        }
        if (filter.getModel() != null) {
            sql.append(" AND model = ?");
        }
        if (filter.getRating() != null) {
            sql.append(" AND rating = ?");
        }

        // Execute query and map to Product objects
        List<MyProduct> products = jdbcTemplate.query(sql.toString(), (resultSet, rowNum) -> {
            MyProduct product = new MyProduct();
            product.setId(resultSet.getLong("id"));
            product.setCategory(resultSet.getString("category"));
            product.setProductName(resultSet.getString("product_name"));
            product.setCost(resultSet.getDouble("cost"));
            product.setColor(resultSet.getString("color"));
            product.setModel(resultSet.getString("model"));
            product.setRating(resultSet.getDouble("rating"));
            return product;
        }, collectParameters(filter));

        return products;
    }

    private Object[] collectParameters(ProductFilter filter) {

        List<Object>  paramsList = new ArrayList<>();
        if(filter.getCategory() != null){
            paramsList.add(filter.getCategory() );
        }

        if(filter.getMinCost() != null){
            paramsList.add(filter.getMinCost() );
        }

        if(filter.getMaxCost() != null){
            paramsList.add(filter.getMaxCost() );
        }

        if(filter.getName() != null){
            paramsList.add(filter.getName() );
        }

        if(filter.getColor() != null){
            paramsList.add(filter.getColor() );
        }

        if(filter.getModel() != null){
            paramsList.add(filter.getModel() );
        }
        if(filter.getRating() != null){
            paramsList.add(filter.getRating() );
        }

        return paramsList.toArray();

    }

}
