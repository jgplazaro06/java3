(function() {
    angular
        .module('app')
        .controller('CartController', CartController);

    CartController.$inject = ['$state', '$location', 'UserService'];

    function CartController($state, $location, UserService) {
        var vm = this;
        vm.hideAll = true;
        vm.cart = null;

        UserService.getCart().then(function(cart) {
            vm.hideAll = false;
            vm.cart = cart;
        }, function(error) {
            // TODO: check the error object if the cause of error is
            // that user is not logged in
            $state.go('login', {
                returnUrl: $location.path()
            });
        });
    }
})();