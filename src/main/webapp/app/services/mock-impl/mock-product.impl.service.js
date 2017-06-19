(function() {
    'use strict';

    angular
        .module('app')
        .service('MockProductServiceImpl', MockProductServiceImpl);

    MockProductServiceImpl.$inject = ['$q'];

    function MockProductServiceImpl($q) {
        var products = [
            {
                productId: 1,
                productName: 'What is love?',
                productPrices: [
                    {
                        referenceId: 1,
                        productId: 1,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 2,
                productName: 'Koi wa nandesuka?',
                productPrices: [
                    {
                        referenceId: 2,
                        productId: 2,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 3,
                productName: 'Tabemashyou!',
                productPrices: [
                    {
                        referenceId: 3,
                        productId: 3,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 4,
                productName: 'Tumaba ka ata???',
                productPrices: [
                    {
                        referenceId: 4,
                        productId: 4,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            }
        ];

        return {
            getProducts: function(page, count, filters, sortMethod) {
                var deferred = $q.defer();

                setTimeout(function() {
                    var pricedProducts = products.map(function(product) {
                        product.productPrice = product.productPrices[0];
                        return product;
                    });
                    deferred.resolve(pricedProducts);
                }, 1000);

                return deferred.promise;
            },
            getProduct: function (id) {
                var deferred = $q.defer();

                setTimeout(function() {
                    var filteredProducts = products.filter(function(product) {
                        return product.productId === id;
                    }).map(function(product) {
                        product.productPrice = product.productPrices[0];
                        return product;
                    });
                    deferred.resolve(filteredProducts[0]);
                }, 1000);

                return deferred.promise;
            }
        }
    }
})();