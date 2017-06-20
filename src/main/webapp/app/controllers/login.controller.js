(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$state', '$stateParams', '$location', 'AuthService'];

    function LoginController($state, $stateParams, $location, AuthService) {
        var vm = this;
        vm.hasReturnUrl = false;
        vm.returnUrl = '';
        vm.username = '';
        vm.password = '';

        vm.login = function() {
            // TODO: perform data validation here

            AuthService.login(vm.username, vm.password).then(function(userdata) {
                if (vm.hasReturnUrl) {
                    $location.url(vm.returnUrl);
                } else {
                    $state.go('home');
                }
            }, function (error) {
                // TODO: check the error object for details about the
                // failure of user's login
            });
        };

        vm.register = function() {
            var params = {};
            if (vm.hasReturnUrl) {
                params.returnUrl = vm.returnUrl;
            }

            $state.go('register', params);
        };

        if ($stateParams.returnUrl) {
            vm.hasReturnUrl = true;
            vm.returnUrl = $stateParams.returnUrl;
        }
    }
})();