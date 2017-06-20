(function() {
    'use strict';

    angular
        .module('app')
        .controller('AppAlertsController', AppAlertsController);

    AppAlertsController.$inject = ['$scope', 'AppAlertsService'];

    function AppAlertsController($scope, AppAlertsService) {
        $scope.alerts = [];

        $scope.close = function(alertIndex) {
            $scope.alerts.splice(alertIndex, 1);
        };

        var addAlert = function(alertType, alertMessage, timeout) {
            $scope.alerts.push({
                type: alertType,
                msg: alertMessage,
                timeout: timeout
            });
        };

        AppAlertsService.subscribe($scope, function(event, alertType, alertMessage, timeout) {
            addAlert(alertType, alertMessage, timeout);
        });
    }
})();