(function (angular) {
    'use strict';
    angular.module('includeExample', [])

        .factory('webServices', ['$http', function ($http) {
            return {
                getVersions: function () {
                    return $http.get('/version/test').then(function (response) {
                        return response.data;
                    });
                }
            }
        }])


        .controller('ExampleController', ['$scope', '$http', 'webServices', function ($scope, $http, webServices) {
            webServices.getVersions().then(function (response) {
                $scope.abtestdata = response; //Assign data
            });


        }])

        .directive('myFeature', function () {

            return {
                scope: true,
                link: function (scope, element, attrs) {
                    scope.$watch('abtestdata', function (newval, oldval) {
                        if (newval) {
                            var key = attrs.name;
                            scope.featureDetails = scope.abtestdata[key];
                            scope.featureType = key;
                        }
                    });

                },
                templateUrl: 'template.html'
            };

        });
})(window.angular);