app.controller('brandController', function ($scope,$controller, brandService) {

    $controller('baseController',{$scope:$scope});

    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }



    $scope.findPage = function (pageNum, pageSize) {
        brandService.findPage(pageNum,pageSize).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

    $scope.save = function () {
        var serviceObject;//服务层对象

        if ($scope.entity.id != null) {
            serviceObject=brandService.update($scope.entity);
        }else{
            serviceObject=brandService.add($scope.entity);
        }

        serviceObject.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }



    $scope.del = function () {
        brandService.del($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.searchEntity = {};
    $scope.search = function (pageNum, pageSize) {
        brandService.search(pageNum, pageSize,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }
});
