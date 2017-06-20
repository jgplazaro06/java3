(function() {
    angular
        .module('app')
        .factory('ProductModalService', ProductModalService);

    ProductModalService.$inject = ['$uibModal'];

    function ProductModalService($uibModal) {
        return {
            open: function(productId) {
                return $uibModal.open({
                    animation: true,
                    templateUrl: 'app/templates/product-modal.html',
                    controller: 'ProductModalController',
                    controllerAs: 'vm',
                    resolve: {
                        productId: function() {
                            return productId;
                        }
                    }
                })
            }
        }
    }
})();