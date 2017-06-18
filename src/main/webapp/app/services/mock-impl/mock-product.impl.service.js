(function() {
    'use strict';

    angular
        .module('app')
        .service('MockProductServiceImpl', MockProductServiceImpl);

    MockProductServiceImpl.$inject = ['$q'];

    function MockProductServiceImpl($q) {
        var products = [
            {
                productId: 0,
                productName: 'What is love?',
                productPrices: [
                    {
                        referenceId: 0,
                        productId: 0,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 1,
                productName: 'Koi wa nandesuka?',
                productPrices: [
                    {
                        referenceId: 0,
                        productId: 0,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 2,
                productName: 'Tabemashyou!',
                productPrices: [
                    {
                        referenceId: 0,
                        productId: 0,
                        productPrice: 100.0,
                        referenceDate: new Date()
                    }
                ]
            },
            {
                productId: 3,
                productName: 'Tumaba ka ata???',
                productPrices: [
                    {
                        referenceId: 0,
                        productId: 0,
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
                    deferred.resolve(products);
                }, 1000);

                return deferred.promise;
            },
            getProduct: function (id) {
                var deferred = $q.defer();

                setTimeout(function() {
                    var filteredProducts = products.filter(function(product) {
                        return product.productId === id;
                    });
                    deferred.resolve(filteredProducts[0]);
                }, 1000);

                return deferred.promise;
            }
        }
    }
})();