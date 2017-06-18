(function() {
    angular
        .module('app')
        .controller('AccountController', AccountController);

    AccountController.$inject = ['$state', '$location', 'UserService'];

    function AccountController($state, $location, UserService) {
        var vm = this;
        vm.hideAll = true;
        vm.accountDetails = {};

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