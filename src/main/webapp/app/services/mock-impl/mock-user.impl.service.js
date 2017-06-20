(function() {
    'use strict';

    angular
        .module('app')
        .service('MockUserServiceImpl', MockUserServiceImpl);

    MockUserServiceImpl.$inject = ['$q', 'AuthService'];

    function MockUserServiceImpl($q, AuthService) {
        var accountDetails = {
            fullName: 'John Gabby',
            email: 'jgphello@gmail.com',
            address: '102993 Abeja St., Brgy. Olympia, Makati City',
            gender: 'M',
            contactNumber: '(993) 993-4948'
        };
        var userCart = {
            id: 100,
            contents: [ ]
        };

        return {
            getAccountDetails: function() {
                var deferred = $q.defer();

                AuthService.getUserdata().then(function(userdata) {
                    // TODO: perform the http post (not for create but for
                    // retrieval of data). Include the userdata in it.
                    deferred.resolve(accountDetails);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            changePassword: function(oldPassword, newPassword) {
                var deferred = $q.defer();

                AuthService.checkAuthorization('userChangePassword').then(function(userdata) {
                    // TODO: get user's id from userdata
                    setTimeout(function() {
                        deferred.resolve();
                    }, 1000);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            changeEmail: function(oldEmail, newEmail) {
                var deferred = $q.defer();

                AuthService.checkAuthorization('userChangeEmail').then(function(userdata) {
                    // TODO: get user's id from userdata
                    setTimeout(function() {
                        deferred.resolve();
                    }, 1000);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            getCart: function() {
                var deferred = $q.defer();

                AuthService.checkAuthorization('userCartRetrieval').then(function(userdata) {
                    // TODO: get user's id from userdata
                    deferred.resolve(userCart);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            updateCart: function(cart) {
                var deferred = $q.defer();

                AuthService.checkAuthorization('userCartUpdate').then(function(userdata) {
                    // TODO: get user's id from userdata
                    userCart = cart;
                    deferred.resolve(userCart);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            addProductToCart: function(productId, quantity, branchId) {
                var deferred = $q.defer();

                AuthService.checkAuthorization('userCartAdd').then(function(userdata) {
                    // TODO: get user's id from userdata
                    userCart.contents.push({
                        cartId: userCart.id,
                        productId: productId,
                        quantity: quantity,
                        branchId: branchId
                        // DO NOT STORE REFERENCE ID WHEN THE CART HAS NOT YET BEEN CHECKED OUT
                        // -> what if the product's price changed while the product is in the cart?
                    });

                    deferred.resolve();
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            }
        }
    }
})();