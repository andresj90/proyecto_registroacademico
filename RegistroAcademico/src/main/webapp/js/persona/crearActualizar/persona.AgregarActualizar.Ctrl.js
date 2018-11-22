
var PersonaModule = angular.module('PersonaModule', []);

PersonaModule.controller('personaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
        $scope.coordinador = {}; 
        
        
        if (id) {
            $http.get('api/coordinadores/' + id).then(function (response) {
             $scope.coordinador = response.data;
            }, function (error) {
                console.log(error);
            });
        }


         $scope.registrarCoordinador = function () {
            
           if ($scope.coordinador.nombres && $scope.coordinador.apellidos && $scope.coordinador.genero
                && $scope.coordinador.email && $scope.coordinador.tipo_documento_id &&  $scope.coordinador.nro_documento) {
                        $http.post('api/coordinadores', JSON.stringify($scope.coordinador)).then(function (response) {
                        $scope.coordinador = {}; 
                        $state.go(); 
                
            },function(error) {
              console.log(error);
              });
            }
        }; 
         
         
     $scope.actualizarCoordinador = function(){
            if ($scope.coordinador.nombres && $scope.coordinador.apellidos && $scope.coordinador.genero
                && $scope.coordinador.email && $scope.coordinador.tipo_documento_id &&  $scope.coordinador.nro_documento){
                    //Reinicia la vaariable
                    $scope.coordinador = {}; 
                    // Nombre de la ruta definida en routes
                    $state.go('crearActualizarHorario');
                }, function(error){
                    console.log(error);
                });
            }
        };  

        
    }]); 