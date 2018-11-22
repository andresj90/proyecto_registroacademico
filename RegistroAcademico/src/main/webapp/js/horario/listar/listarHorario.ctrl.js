/* global $scope, $http */

var horarioModule = angular.module('horarioModule'); 

horarioModule.controller('listarHorarioCtrl', ["$scope", "$http", "$state", function ($scope, $http, $state) {
     $scope.horarios = new Array();
             
     $http.get('api/horarios').then(function (response) {
            console.log(response);
            $scope.horarios = response.data;
     }, function (error) {
            console.log(error);
     });   
     
     
          $scope.eliminarHorario = function (horarioId) {
          
            $http.delete('api/horarios/'+horarioId).then(function(response) {
            $state.reload();   
           }, function(error) {
                
                console.log(error);   
            });
            
            
        };    
    
}]);
