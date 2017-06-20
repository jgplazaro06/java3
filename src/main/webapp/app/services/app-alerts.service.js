(function() {
    angular
        .module('app')
        .service('AppAlertsService', AppAlertsService);

    AppAlertsService.$inject = ['$rootScope'];

    function AppAlertsService($rootScope) {
        return {
            subscribe: function(scope, callback) {
                var handler = $rootScope.$on('add-alert', function(event, alertData) {
                    callback(event, alertData.type, alertData.message, alertData.timeout);
                });
                scope.$on('$destroy', handler);
            },
            addAlert: function(alertType, alertMessage, alertTimeout) {
                $rootScope.$emit('add-alert', {
                    type: alertType,
                    message: alertMessage,
                    timeout: alertTimeout
                });
            }
        }
    }
})();