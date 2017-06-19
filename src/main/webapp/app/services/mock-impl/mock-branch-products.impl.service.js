(function() {
    angular
        .module('app')
        .service('MockBranchProductsServiceImpl', MockBranchProductsServiceImpl);

    MockBranchProductsServiceImpl.$inject = ['$q'];

    function MockBranchProductsServiceImpl($q) {
        var branches = [
            {
                branchId: 0,
                address: '20393 The Linear, Malugay St., San Antonio, Makati City'
            },
            {
                branchId: 1,
                address: '6078 Ayala Ave., Makati City'
            }
        ];

        return {
            getBranchesForProduct: function(productId) {
                var deferred = $q.defer();

                setTimeout(function() {
                    deferred.resolve(branches);
                }, 1000);

                return deferred.promise;
            }
        }
    }
})();