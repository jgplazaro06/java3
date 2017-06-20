(function() {
    'use strict';

    angular
        .module('app')
        .directive('appAlerts', AppAlertsDirective);

    function AppAlertsDirective() {
        return {
            restrict: 'E',
            controller: 'AppAlertsController',
            controllerAs: 'vm',
            bindToController: true,
            templateUrl: 'app/directives/app-alerts/app-alerts.html'
        }
    }
})();