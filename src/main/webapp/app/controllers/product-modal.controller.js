(function() {
    angular
        .module('app')
        .controller('ProductModalController', ProductModalController);

    ProductModalController.$inject = ['$uibModalInstance', 'ProductService', 'UserService',
                                      'BranchProductsService', 'productId'];

    function ProductModalController($uibModalInstance, ProductService, UserService,
                                    BranchProductsService, productId) {
        var vm = this;
        vm.isLoading = true;
        vm.isAdding = false;
        vm.quantity = 1;
        vm.product = null;
        vm.productBranches = [];
        vm.selectedBranch = null;

        vm.close = function() {
            $uibModalInstance.dismiss('closed');
        };
        vm.addToCart = function() {
            if (vm.selectedBranch === null || vm.quantity < 1) {
                return;
            }

            vm.isAdding = true;
            UserService.addProductToCart(vm.product.productId, vm.quantity, vm.selectedBranch.branchId)
                .then(function() {
                    $uibModalInstance.dismiss('added-to-cart');
                    vm.isAdding = false;
                }, function() {
                    vm.isAdding = false;
                });
        };

        if (productId) {
            ProductService.getProduct(productId).then(function(product) {
                if (product === null) {
                    // TODO: show not product found
                } else {
                    vm.product = product;
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