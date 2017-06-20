(function() {
    angular
        .module('app')
        .controller('PasswordUpdateController', PasswordUpdateController);

    PasswordUpdateController.$inject = ['$state', '$location', 'UserService', 'AuthService'];

    function PasswordUpdateController($state, $location, UserService, AuthService) {
        var vm = this;
        vm.hideAll = true;
        vm.form = {};

        vm.form.oldPassword = '';
        vm.form.newPassword = '';
        vm.form.confirmNewPassword = '';

        vm.changePassword = function() {
            // TODO: validate form

            UserService.changePassword(vm.form.oldPassword, vm.form.newPassword).then(function() {
                $state.go('account', {
                    isPasswordChangeSuccessful: true
                });
            }, function(error) {
                // TODO: check the cause of error

                $state.go('account', {
                    isPasswordChangeSuccessful: false
                });
            });
        };

        var goToLogin = function() {
            $state.go('login', {
                returnUrl: $location.path()
            });
        };
        AuthService.isLoggedIn().then(function(isLoggedIn) {
            if (isLoggedIn) {
                vm.hideAll = false;
            } else {
                goToLogin();
            }
        }, goToLogin);
    }
})();