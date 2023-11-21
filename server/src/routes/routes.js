const express = require("express");
const promptController = require("../controllers/prompt-controller");
const routes = express.Router();
var cors = require("cors");

var corsOptions = {
	origin: "*",
	optionsSuccessStatus: 200, // some legacy browsers (IE11, various SmartTVs) choke on 204
};
routes.post("/api/prompt", cors(corsOptions), promptController.sendText);

module.exports = routes;
