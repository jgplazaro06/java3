(function() {
    angular
        .module('app')
        .factory('AuthService', AuthService);

    AuthService.$inject = ['$injector'];

    function AuthService($injector) {
        // TODO: replace with real service implementation for production
        return $injector.get('MockAuthServiceImpl');
    }
})();