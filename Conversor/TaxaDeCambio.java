package Conversor;

import com.google.gson.annotations.SerializedName;

public record TaxaDeCambio(@SerializedName("conversion_rate") double conversionRate) { }

