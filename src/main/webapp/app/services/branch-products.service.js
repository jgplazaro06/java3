(function() {
    angular
        .module('app')
        .factory('BranchProductsService', BranchProductsService);

    BranchProductsService.$inject = ['$injector'];

    function BranchProductsService($injector) {
        // TODO: replace with real service implementation for production
        return $injector.get('MockBranchProductsServiceImpl');
    }
})();