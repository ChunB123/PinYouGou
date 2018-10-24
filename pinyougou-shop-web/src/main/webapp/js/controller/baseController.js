app.controller('baseController',function($scope){
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //选中的id集合
    $scope.selectIds = [];

    //更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);
        }
    }






    $scope.jsonToString=function(string,key){
        var json=JSON.parse(string);
        var value="";
        for(i=0;i<json.length;i++){
            json[i][key]="xxxx";
            if(i>0){
                value+=",";
            }
            value+=json[i][key];
        }
        return value;
    }
});