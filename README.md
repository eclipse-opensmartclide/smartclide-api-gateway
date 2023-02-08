# smartclide-api-gateway

SmartCLIDE API Gateway is wrapper module around all RESTful APIs create within the SmartCLIDE platform.

It provides a common interface for accessing the different RESTful APIs, while in the same time preserves the interface of each of them.

In this way, the SmartCLIDE API Gateway provides an interoperable way of accessing the services of the different SmartCLIDE backend components from the frontend side.

The SmartCLIDE API Gateway serves as a single point of access for all SmartCLIDE Backend components.

The SmartCLIDE API Gateway defines the following common interface for SmartCLIDE RESTful APIs:

**https://api.dev.smartclide.eu/{component_name}/{component_resource}**

Examples:

- **Jave code generation (POST endpoint from the DLE RESTful API)**:

	http://smartclide.ddns.net:5001/smartclide/v1/dle/codegen

	becomes

	https://api.dev.smartclide.eu/dle/codegen


- **TD Principal analysis (POST endpoint from the TD Principal RESTful API)**:

	https://td-principal.smartclide-td/api/analysis

	becomes

	https://api.dev.smartclide.eu/td-principal/analysis

The SmartCLIDE API Gateway supports the following {component_name} elements:

- **mom**
- **websocket**
- **smartclide-db**
- **smart-assistant**
- **cicd**
- **deployment-interpreter**
- **deployment-service**
- **external-project-importer**
- **dle**
- **iamodeler**
- **service-discovery**
- **service-creation**
- **service-creation-test-generation**
- **td-interest**
- **td-principal**
- **td-reusability**
- **architectural-patterns**
