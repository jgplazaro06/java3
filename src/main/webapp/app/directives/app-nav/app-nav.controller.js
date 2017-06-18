(function() {
    'use strict';

    angular
        .module('app')
        .controller('AppNavController', AppNavController);

    AppNavController.$inject = ['$scope', '$state', '$location', 'AuthService'];

    function AppNavController($scope, $state, $location, AuthService) {
        var vm = this;

        vm.isCollapsed = true;
        vm.isAuthReady = false;
        vm.isLoggedIn = false;

        vm.goToLoginPage = function() {
            $state.go('login', {
                returnUrl: $location.path()
            });
        };
        vm.goToRegistrationPage = function() {
            $state.go('register', {
                returnUrl: $location.path()
            });
        };
        vm.goToCartPage = function() {
            $state.go('cart');
        };
        vm.goToAccountPage = function() {
            $state.go('account');
        };
        vm.logOut = function() {
            AuthService.logout('userId', 'token').then(function() {
                $state.go('home');
            });
        };
        vm.refreshState = function() {
            AuthService.isLoggedIn().then(function(isLoggedIn) {
                vm.isLoggedIn = isLoggedIn;
            }).finally(function() {
                vm.isAuthReady = true;
            });
        };

        AuthService.subscribe($scope, function() {
            vm.refreshState();
        });

        vm.refreshState();
    }
})();