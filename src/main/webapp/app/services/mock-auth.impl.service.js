(function() {
    angular
        .module('app')
        .service('MockAuthServiceImpl', MockAuthServiceImpl);

    MockAuthServiceImpl.$inject = ['$rootScope', '$q'];

    function MockAuthServiceImpl($rootScope, $q) {
        var isLoggedIn = false;

        var notifySubscribers = function() {
            $rootScope.$emit('login-update');
        };

        return {
            subscribe: function(scope, callback) {
                var handler = $rootScope.$on('login-update', callback);
                scope.$on('$destroy', handler);
            },
            isLoggedIn: function() {
                var deferred = $q.defer();

                setTimeout(function () {
                    deferred.resolve(isLoggedIn);
                }, 1000);

                return deferred.promise;
            },
            checkAuthorization: function(requestCode, userId, token) {
                var deferred = $q.defer();

                setTimeout(function () {
                    deferred.resolve();
                }, 1000);

                return deferred.promise;
            },
            login: function(username, password) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = true;

                    deferred.resolve({
                        userId: '192883',
                        token: '10Ij2-&&91j-psoi('
                    });

                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            },
            logout: function(userId, token) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = false;

                    deferred.resolve();

                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            },
            register: function(userDetails) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = true;

                    deferred.resolve({
                        userId: '192883',
                        token: '10Ij2-&&91j-psoi('
                    });

                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            }
        }
    }
})();