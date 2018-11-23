/* global inscripcion */

var InscripcionModule = angular.module('InscripcionModule');

InscripcionModule.controller('crearInscripcionCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
       $scope.convertirAPalabra = function (dato){
                
                return dato.toString();
       }


        $scope.Inscripcion = {};

        if (id) {
            $http.get('api/inscripciones/' + id).then(function (response) {
                $scope.Inscripcion = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearInscripcion = function () {
            console.log($scope.Inscripcion);
            if ($scope.Inscripcion.nombreInscripcion) {
                $http.post('api/inscripciones', JSON.stringify($scope.inscripcion)).then(function (response) {
                    console.log(response.data);
                    //Reinicia la vaariable
                    $scope.Inscripcion = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarInscripcion');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarInscripcion = function(){
            if ($scope.tipoCurso.nombre) {
                $http.put('api/inscripciones/'+id, JSON.stringify($scope.Inscripcion)).then(function(response){
                    //Reinicia la variable
                    $scope.Inscripcion = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarInscripciones');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);



