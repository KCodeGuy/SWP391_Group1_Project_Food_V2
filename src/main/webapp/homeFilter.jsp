<%-- 
    Document   : homeFilter
    Created on : Mar 1, 2023, 11:31:57 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- 3. Product body -->
<div class="container-fluid home-filter">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <nav class="navbar navbar-expand-lg">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item nav-menu-label">
                                <h4>Menu:</h4>
                            </li>
                            <li class="nav-item nav-item-home-filter">
                                <a href="category?categoryID=FOOD" class="nav-link" aria-current="page">
                                    <img class="home-filter-icon" src="./assert/img/food.png" alt="alt"/>    
                                    Food
                                </a>
                            </li>
                            <li class="nav-item nav-item-home-filter">
                                <img class="home-filter-icon" src="./assert/img/drink.png" alt="alt"/> 
                                <a href="category?categoryID=DRINK" class="nav-link">Drink</a>
                            </li>

                            <li class="nav-item nav-item-home-filter">
                                <img class="home-filter-icon" src="./assert/img/soup.png" alt="alt"/> 
                                <a href="category?categoryID=SOUP" class="nav-link">Soup</a>
                            </li>

                            <li class="nav-item nav-item-home-filter">
                                <img class="home-filter-icon" src="./assert/img/conmbo.png" alt="alt"/> 
                                <a href="category?categoryID=COMBO" class="nav-link">Combo</a>
                            </li>
                        </ul>
                        <div class="sort-form">
                            <form class="sort-form" action="sort-product-home">
                                <span class="sort-form-label">ORDER BY:</span>
                                <select  name="txtSort" id="sort-product">
                                    <option value="asc" selected="${txtSort eq 'asc'}">Price ascending</option>
                                    <option value="desc" selected="${txtSort eq 'asc'}">Price descending</option>
                                </select>
                                <button type="submit" class="btn-primary btn-sort"><i class="fa-solid fa-arrow-up-a-z"></i>Sort</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>