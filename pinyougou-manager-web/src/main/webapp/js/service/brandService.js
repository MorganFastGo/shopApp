app.service('brandService',function($http){
    	this.findAll=function(){
    		return $http.get('../brand/findAll.do');
    	}
    	
    	this.findPage=function(pageNum,pageSize){
    		return $http.get('../brand/findPage.do?page='+pageNum+'&rows='+pageSize);
    	}
    	
    	this.findOne=function(id){
    		return $http.get('../brand/findOne.do?id='+id);
    	}
    	
    	this.dele=function(selectIds){
    		return $http.get('../brand/delete.do?ids='+selectIds);
    	}
    	
    	this.search=function(pageNum,pageSize,searchEntity){
    		return $http.post('../brand/search.do?page='+pageNum+'&rows='+pageSize,searchEntity);
    	}
    	
    	this.add=function(entity){
    		return $http.post('../brand/add.do',entity);
    	}
    	
    	this.update=function(entity){
    		return $http.post('../brand/update.do',entity);
    	}
    });