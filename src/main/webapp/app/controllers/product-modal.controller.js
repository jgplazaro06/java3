(function() {
    angular
        .module('app')
        .controller('ProductModalController', ProductModalController);

    ProductModalController.$inject = ['$state', '$uibModalInstance', 'ProductService', 'UserService',
                                      'BranchProductsService', 'AuthService', 'productId'];

    function ProductModalController($state, $uibModalInstance, ProductService, UserService,
                                    BranchProductsService, AuthService, productId) {
        var vm = this;
        vm.isLoggedIn = false;
        vm.isLoading = true;
        vm.isAdding = false;
        vm.quantity = 1;
        vm.product = null;
        vm.productBranches = [];
        vm.selectedBranch = null;

        vm.close = function() {
            $uibModalInstance.dismiss('closed');
        };
        vm.login = function() {
            $uibModalInstance.dismiss('closed');
            $state.go('login');
        };
        vm.addToCart = function() {
            if (vm.selectedBranch === null || vm.quantity < 1) {
                return;
            }

            vm.isAdding = true;
            UserService.addProductToCart(vm.product.productId, vm.quantity, vm.selectedBranch.branchId)
                .then(function() {
                    $uibModalInstance.close('added-to-cart');
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
                    return BranchProductsService.getBranchesForProduct(productId);
                }
            }).then(function(branches) {
                vm.productBranches = branches;
                return AuthService.isLoggedIn();
            }).then(function(isLoggedIn) {
                vm.isLoggedIn = isLoggedIn;
                vm.isLoading = false;
            });
        } else {
            $uibModalInstance.dismiss('no-product-id');
        }
    }
})();