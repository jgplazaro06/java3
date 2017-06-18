(function() {
    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['$state', '$stateParams', '$location', 'AuthService'];

    function RegisterController($state, $stateParams, $location, AuthService) {
        var vm = this;
        vm.hasReturnUrl = false;
        vm.returnUrl = '';

        vm.form = {};

        vm.reset = function() {
            vm.form.fullName = '';
            vm.form.email = '';
            vm.form.password = '';
            vm.form.confirmPassword = '';
            vm.form.contactNumber = '';
            vm.form.address = '';
            vm.form.gender = '';
        };
        vm.reset();

        vm.register = function() {
            // TODO: validate form here

            AuthService.register({
                fullName: vm.form.fullName,
                email: vm.form.email,
                password: vm.form.password,
                contactNumber: vm.form.contactNumber,
                address: vm.form.address,
                gender: vm.form.gender
            }).then(function(userdata) {
                if (vm.hasReturnUrl) {
                    $location.url(vm.returnUrl);
                } else {
                    $state.go('home');
                }
            }, function(error) {
                // TODO: check the error object for details about the
                // failure of user's registration
            });
        };

        vm.login = function() {
            var params = {};
            if (vm.hasReturnUrl) {
                params.returnUrl = vm.returnUrl;
            }

            $state.go('login', params);
        };

        if ($stateParams.returnUrl) {
            vm.hasReturnUrl = true;
            vm.returnUrl = $stateParams.returnUrl;
        }
    }
})();