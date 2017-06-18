(function() {
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
            id: '',
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
            getCart: function() {
                var deferred = $q.defer();

                AuthService.getUserdata().then(function(userdata) {
                    return AuthService.checkAuthorization(userdata, 'userCartRetrieval');
                }, function(error) {
                    deferred.reject(error);
                }).then(function() {
                    deferred.resolve(userCart);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            },
            updateCart: function(cart) {
                var deferred = $q.defer();

                AuthService.getUserdata().then(function(userdata) {
                    return AuthService.checkAuthorization(userdata, 'userCartUpdate');
                }, function(error) {
                    deferred.reject(error);
                }).then(function() {
                    userCart = cart;
                    deferred.resolve(userCart);
                }, function(error) {
                    deferred.reject(error);
                });

                return deferred.promise;
            }
        }
    }
})();