package com.example.demo1.ECOMMERCE;

public class ALLCODES {
    public String addUser(UserDto userDto){
        User user=new User();
        user.setUsername(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return "User added Successfully";




        public String addProduct(ProductDto productDto){
            Product product=new Product();
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
            return "Product added Successfully";




            public Product getMaxPriceProduct(Category category){
                List<Product> productList=productRepository.findAll();
                Product product=null;
                int productPrice=Integer.MIN_VALUE;
                for(Product p: productList){
                    if(p.getCategory().equals(category)&&p.getPrice()>productPrice){
                        product=p;
                    }
                }
                return product;



                public List<Product> getOrder(OrderDto orderDto){
                    Order oder=new Order();
                    List<Product>result=new ArrayList<>();
                    User user= userRepository.findById(orderDto.getUserId()).get();
                    List<Product>productList=productRepository.findAll();
                    for(Product p:productList){
                        if(p.getName().charAt(0)=='A'){
                            result.add(p);
                        }
                    }
                    return result;



                    public Order createOrderWithMinimumPriceInEachCategory() {
                        List<Product> products = productRepository.findAll();

                        // create a list of categories
                        List<String> categories = new ArrayList<>();
                        for (Product product : products) {
                            String category = product.getCategory();
                            if (!categories.contains(category)) {
                                categories.add(category);
                            }
                        }

                        // create a list of minimum priced products for each category
                        List<Product> minProducts = new ArrayList<>();
                        for (String category : categories) {
                            Product minProduct = null;
                            for (Product product : products) {
                                if (product.getCategory().equals(category)) {
                                    if (minProduct == null || product.getPrice().compareTo(minProduct.getPrice()) < 0) {
                                        minProduct = product;
                                    }
                                }
                            }
                            minProducts.add(minProduct);
                        }

                        // create the order with the selected products and payment mode
                        Order order = new Order();
                        order.setUser(currentUser);
                        order.setProducts(minProducts);
                        order.setPaymentMode(PaymentMode.CREDIT_CARD);

                        return orderRepository.save(order);
                    }



                }
