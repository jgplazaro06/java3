(function() {
    'use strict';

    angular
        .module('app')
        .factory('ProductService', ProductService);

    ProductService.$inject = ['$injector'];

    function ProductService($injector) {
        // TODO: replace with real service implementation for production
        return $injector.get('MockProductServiceImpl');
    }
})();