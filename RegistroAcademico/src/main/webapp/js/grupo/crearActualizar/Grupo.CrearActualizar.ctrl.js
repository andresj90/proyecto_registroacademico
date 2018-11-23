/* global tipocurso */

var GrupoModule = angular.module('GrupoModule');

GrupoModule.controller('crearGrupoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
       $scope.convertirAPalabra = function (dato){
                
                return dato.toString();
       }


        $scope.grupo = {};

        if (id) {
            $http.get('api/grupos/' + id).then(function (response) {
                $scope.grupo = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearGrupo = function () {
            console.log($scope.grupo);
            if ($scope.grupo.nombreGrupo) {
                $http.post('api/grupos', JSON.stringify($scope.grupo)).then(function (response) {
                    console.log(response.data);
                    //Reinicia la vaariable
                    $scope.grupo = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarGrupo');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarGrupo = function(){
            if ($scope.grupo.nombreGrupo) {
                
                   $http.put('api/grupos/' + id ,JSON.stringify($scope.grupo)).then(function (response) {
                   $scope.grupo = {}; 
                   $state.go('listarGrupo');
                
            }, function (error) {
                    
                    console.log(error);
               });  
            }
        };
    }]);


