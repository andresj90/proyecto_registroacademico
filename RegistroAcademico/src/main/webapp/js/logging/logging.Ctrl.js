var LoggingModule = angular.module('LoggingModule', []);

LoggingModule.controller('loggingCtrl', ['$scope', '$htpp', '$state', function ($scope, $http, $state ) {
        
        $scope.usuario = new Array();
        
        $scope.obtenerUsuario = new function (usuario) {
            
        $http.get('api/coordinadores/'+ usuario).then(function (response) {
            
            
          
        });
            
            
        }
        
 
        
    }]);

