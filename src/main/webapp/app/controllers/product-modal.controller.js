(function() {
    angular
        .module('app')
        .controller('ProductModalController', ProductModalController);

    ProductModalController.$inject = ['$uibModalInstance', 'ProductService', 'BranchProductsService', 'productId'];

    function ProductModalController($uibModalInstance, ProductService, BranchProductsService, productId) {
        var vm = this;
        vm.isLoading = true;
        vm.quantity = 1;
        vm.product = null;
        vm.productPrice = null;
        vm.productBranches = [];

        vm.close = function() {
            $uibModalInstance.dismiss('closed');
        };

        if (productId) {
            ProductService.getProduct(productId).then(function(product) {
                if (product === null) {
                    // TODO: show not product found
                } else {
                    vm.product = product;
                    vm.productPrice = product.productPrices[0];
                    BranchProductsService.getBranchesForProduct(productId).then(function(branches) {
                        vm.productBranches = branches;
                        vm.isLoading = false;
                    });
                }
            });
        } else {
            $uibModalInstance.dismiss('no-product-id');
        }
    }
})();