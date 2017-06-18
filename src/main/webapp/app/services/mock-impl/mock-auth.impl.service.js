(function() {
    angular
        .module('app')
        .service('MockAuthServiceImpl', MockAuthServiceImpl);

    MockAuthServiceImpl.$inject = ['$rootScope', '$q'];

    function MockAuthServiceImpl($rootScope, $q) {
        var isLoggedIn = false;
        var userdata = null;

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
            checkAuthorization: function(resourceToAccess) {
                var deferred = $q.defer();

                setTimeout(function () {
                    if (isLoggedIn) {
                        // TODO: Perform a request to check if the user can
                        // access the requested resource using information
                        // in the userdata.

                        deferred.resolve();
                    } else {
                        deferred.reject();
                    }
                }, 1000);

                return deferred.promise;
            },
            getUserdata: function() {
                var deferred = $q.defer();

                setTimeout(function () {
                    if (isLoggedIn) {
                        deferred.resolve(userdata);
                    } else {
                        deferred.reject();
                    }
                }, 1000);

                return deferred.promise;
            },
            login: function(username, password) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = true;
                    userdata = {
                        userId: '192883',
                        token: '10Ij2-&&91j-psoi('
                    };

                    deferred.resolve(userdata);
                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            },
            logout: function(userId, token) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = false;
                    userdata = null;

                    deferred.resolve();
                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            },
            register: function(userDetails) {
                var deferred = $q.defer();

                setTimeout(function () {
                    isLoggedIn = true;
                    userdata = {
                        userId: '192883',
                        token: '10Ij2-&&91j-psoi('
                    };

                    deferred.resolve(userdata);
                    notifySubscribers();
                }, 3000);

                return deferred.promise;
            }
        }
    }
})();