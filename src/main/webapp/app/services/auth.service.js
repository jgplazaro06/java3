(function() {
    angular
        .module('app')
        .factory('AuthService', AuthService);

    AuthService.$inject = ['$injector'];

    function AuthService($injector) {
        return $injector.get('MockAuthServiceImpl');
    }
})();