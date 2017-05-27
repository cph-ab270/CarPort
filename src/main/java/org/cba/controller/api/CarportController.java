package org.cba.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.cba.domain.Carport;
import org.cba.model.carport.calculation.Dimensions;
import org.cba.model.carport.calculation.PriceCalculator;
import org.cba.model.carport.calculation.exception.MaterialLengthVariationNotFoundException;
import org.cba.parameter.ParsedParameters;
import org.cba.parameter.exception.ParameterParserException;
import org.cba.parameter.filters.CarportDimensionsFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by adam on 19/04/2017.
 */
public class CarportController extends ApiController {
    public CarportController(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void getPrice(Integer carportId) {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        try {
            ParsedParameters parameters = CarportDimensionsFilter.getParameters(request);
            Carport carport = Carport.find.byId(carportId);
            PriceCalculator calculator = new PriceCalculator();
            Dimensions requestedCarportDimensions = new Dimensions(
                    parameters.getInteger("frameWidth"),
                    parameters.getInteger("frameLength")
            );
            int price = calculator.getPrice(carport,requestedCarportDimensions);
            objectNode.put("price", price);
        } catch (ParameterParserException | MaterialLengthVariationNotFoundException e) {
            objectNode.put("error", e.getMessage());
        }
        returnJSON(objectNode.toString());
    }
}
