(function() {
    angular
        .module('app')
        .controller('AccountController', AccountController);

    AccountController.$inject = ['$state', '$stateParams', '$location', 'UserService'];

    function AccountController($state, $stateParams, $location, UserService) {
        var vm = this;

        vm.hideAll = true;
        vm.shouldShowPasswordSuccessful = $stateParams.isPasswordChangeSuccessful !== null;
        vm.shouldShowEmailSuccessful = $stateParams.isEmailChangeSuccessful !== null;
        vm.changePasswordSuccessful = $stateParams.isPasswordChangeSuccessful;
        vm.changeEmailSuccessful = $stateParams.isEmailChangeSuccessful;
        vm.accountDetails = null;

        vm.changePassword = function() {
            $state.go('password-update');
        };

        vm.changeEmail = function() {
            // not yet supported
        };


        UserService.getAccountDetails().then(function(accountDetails) {
            vm.hideAll = false;
            vm.accountDetails = accountDetails;

            if (vm.accountDetails.gender === 'M') {
                vm.accountDetails.genderText = 'Male'
            } else if (vm.accountDetails.gender === 'F') {
                vm.accountDetails.genderText = 'Female'
            } else {
                vm.accountDetails.genderText = 'Unknown'
            }
        }, function(error) {
            // TODO: check the error object if the cause of error is
            // that user is not logged in
            $state.go('login', {
                returnUrl: $location.path()
            });
        });
    }
})();