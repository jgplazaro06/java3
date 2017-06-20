(function() {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['ProductService', 'ProductModalService', 'AppAlertsService'];

    function HomeController(ProductService, ProductModalService, AppAlertsService) {
        var vm = this;
        vm.products = [];
        vm.isLoadingProducts = true;

        vm.maxPages = 0;
        vm.currentPage = 1;
        vm.productsPerPage = 10;
        vm.visiblePageNumbers = [];
        vm.disabledPreviousPage = false;
        vm.disabledNextPage = false;

        vm.filter = {};
        vm.filter.showOnlyAvailable = false;
        vm.isSortMethodDropdownOpen = false;
        vm.sortMethod = '';

        vm.viewProduct = function(productId) {
            var productModal = ProductModalService.open(productId);
            productModal.result.then(function() {
                AppAlertsService.addAlert('success', 'The product was successfully added to the cart!', 3000);
            }, function(reason) {
                if (reason === 'no-product-id') {
                    // TODO: show an error alert that there was no product id passed to the modal
                }
            });
        };
        vm.refreshPagination = function() {
            var count = 5; // hard-coded value. number of page links in pagination
            var countM1 = count - 1;

            var max = vm.maxPages; // last page that can be browsed
            var maxEnd = max - countM1; // maximum value of end
            var diffM = vm.currentPage - Math.ceil(count / 2);

            var start = diffM < 1 ? 1 : diffM + 1;
            start = start > maxEnd ? maxEnd : start;
            var end = start + countM1;

            vm.visiblePageNumbers = [];
            for (var i = start; i <= end; i++)
                vm.visiblePageNumbers.push(i);

            vm.disabledPreviousPage = vm.currentPage === 1;
            vm.disabledNextPage = vm.currentPage === vm.maxPages;
        };
        vm.refreshProducts = function() {
            ProductService.getProducts(vm.currentPage, vm.productsPerPage, vm.filter, vm.sortMethod)
                .then(function(products, maxPages) {
                    vm.products = products;
                    vm.isLoadingProducts = false;

                    vm.maxPages = maxPages;
                    vm.maxPages = 7; // TODO: replace this hardcoded value

                    vm.refreshPagination();
                });
        };
        vm.previousPage = function() {
            vm.currentPage--;
            if (vm.currentPage > 0)
                vm.refreshProducts();
            else
                vm.currentPage = 1;
        };
        vm.nextPage = function() {
            vm.currentPage++;
            if (vm.currentPage <= vm.maxPages)
                vm.refreshProducts();
            else
                vm.currentPage = vm.maxPages;
        };
        vm.goToPage = function(pageNumber) {
            vm.currentPage = pageNumber;
            vm.refreshProducts();
        };
        vm.setSortMethod = function(sortMethod) {
            vm.sortMethod = sortMethod;
            switch (vm.sortMethod) {
                case 'asc-price':
                    vm.sortMethodText = 'ascending price';
                    break;
                case 'asc-name':
                    vm.sortMethodText = 'ascending name';
                    break;
                case 'desc-price':
                    vm.sortMethodText = 'descending price';
                    break;
                case 'desc-name':
                    vm.sortMethodText = 'descending name';
                    break;
            }
        };

        vm.setSortMethod('asc-name');
        vm.refreshProducts();
    }
})();