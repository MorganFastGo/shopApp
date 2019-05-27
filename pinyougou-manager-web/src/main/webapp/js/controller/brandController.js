 app.controller("brandController",function($scope,$controller,$http,brandService){
    	
	 $controller('baseController',{$scope:$scope});//继承
	 
	 $scope.findAll=function(){
    		brandService.findAll().success(
    			function(response){
    				$scope.list=response;
    			}
    	  	);
    	};   	
    	
    	$scope.findPage=function(pageNum,pageSize){
    		brandService.findPage(pageNum,pageSize).success(
    				function(response){
    			$scope.list=response.rows;
    			$scope.paginationConf.totalItems=response.totalPage;
    		});
    	}
    	
   		$scope.save=function(){
   			var object=brandService.add($scope.entity);
   			if($scope.entity.id !=null){
   				object=brandService.update($scope.entity);
   			}
   			object.success(
    			function(response){
    			if(response.success){
    				$scope.reloadList();
    			}else{
    				alert(response.message);
    			}
    		})
    		
    	} 
   		$scope.clear=function(){
   			$scope.entity={};
   		} 
   		$scope.findOne=function(id){
   			
   			brandService.findOne(id).success(
   					function(response){
   				$scope.entity=response;
   			})
   		}
   		
   		
   		
   		$scope.dele=function(){
   			brandService.dele($scope.selectIds).success(
   					function(response){
   						if(response.success){
   							$scope.reloadList();
   						}else{
   							alert(response.message);
   						}
   					}
   			)	
   		}
   		
   		$scope.search=function(pageNum,pageSize){
   			brandService.search(pageNum,pageSize,$scope.searchEntity).success(
   					function(response){
   				$scope.list=response.rows;
   				$scope.paginationConf.totalItems=response.totalPage;
   			})
   			
   		}
    	
    });