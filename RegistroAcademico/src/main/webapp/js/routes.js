var app = angular.module('RegistroAcademico');

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) { 
       
        //Otherwise - control 404
        $urlRouterProvider.otherwise('/');
        
        //Por cada ruta se crea un nuevo estado
        
        $stateProvider.state("mainPage", {
            
            url: '/' , 
            
            views:{
                
                mainView:{
                    
                    templateUrl : 'index.html'
                }
            }
        });
        
         $stateProvider.state("crearActualizarHorario", {
           url: '/horario' ,
           views:{
               mainView: {
                   templateUrl: 'js/curso/crearActualizar/CrearHorario.html',
                   controller: 'crearHorarioCtrl'
               }
           }
        });

}]); 