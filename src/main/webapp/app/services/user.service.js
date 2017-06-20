(function() {
    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$injector'];

    function UserService($injector) {
        // TODO: replace with real service implementation for production
        return $injector.get('MockUserServiceImpl');
    }
})();