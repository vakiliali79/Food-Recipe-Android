package com.alivakili.food_recipe.recipeData


import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("from")
    val from: Int? = 0,
    @SerializedName("hits")
    val hits: List<Hit?>? = listOf(),
    @SerializedName("_links")
    val links: Links? = Links(),
    @SerializedName("to")
    val to: Int? = 0
) {
    data class Hit(
        @SerializedName("_links")
        val links: Links? = Links(),
        @SerializedName("recipe")
        val recipe: Recipe? = Recipe()
    ) {
        data class Links(
            @SerializedName("self")
            val self: Self? = Self()
        ) {
            data class Self(
                @SerializedName("href")
                val href: String? = "",
                @SerializedName("title")
                val title: String? = ""
            )
        }

        data class Recipe(
            @SerializedName("calories")
            val calories: Double? = 0.0,
            @SerializedName("cautions")
            val cautions: List<String?>? = listOf(),
            @SerializedName("co2EmissionsClass")
            val co2EmissionsClass: String? = "",
            @SerializedName("cuisineType")
            val cuisineType: List<String?>? = listOf(),
            @SerializedName("dietLabels")
            val dietLabels: List<String?>? = listOf(),
            @SerializedName("digest")
            val digest: List<Digest?>? = listOf(),
            @SerializedName("dishType")
            val dishType: List<String?>? = listOf(),
            @SerializedName("healthLabels")
            val healthLabels: List<String?>? = listOf(),
            @SerializedName("image")
            val image: String? = "",
            @SerializedName("images")
            val images: Images? = Images(),
            @SerializedName("ingredientLines")
            val ingredientLines: List<String?>? = listOf(),
            @SerializedName("ingredients")
            val ingredients: List<Ingredient?>? = listOf(),
            @SerializedName("label")
            val label: String? = "",
            @SerializedName("mealType")
            val mealType: List<String?>? = listOf(),
            @SerializedName("shareAs")
            val shareAs: String? = "",
            @SerializedName("source")
            val source: String? = "",
            @SerializedName("totalCO2Emissions")
            val totalCO2Emissions: Double? = 0.0,
            @SerializedName("totalDaily")
            val totalDaily: TotalDaily? = TotalDaily(),
            @SerializedName("totalNutrients")
            val totalNutrients: TotalNutrients? = TotalNutrients(),
            @SerializedName("totalTime")
            val totalTime: Double? = 0.0,
            @SerializedName("totalWeight")
            val totalWeight: Double? = 0.0,
            @SerializedName("uri")
            val uri: String? = "",
            @SerializedName("url")
            val url: String? = "",
            @SerializedName("yield")
            val yield: Double? = 0.0
        ) {
            data class Digest(
                @SerializedName("daily")
                val daily: Double? = 0.0,
                @SerializedName("hasRDI")
                val hasRDI: Boolean? = false,
                @SerializedName("label")
                val label: String? = "",
                @SerializedName("schemaOrgTag")
                val schemaOrgTag: String? = "",
                @SerializedName("sub")
                val sub: List<Sub?>? = listOf(),
                @SerializedName("tag")
                val tag: String? = "",
                @SerializedName("total")
                val total: Double? = 0.0,
                @SerializedName("unit")
                val unit: String? = ""
            ) {
                data class Sub(
                    @SerializedName("daily")
                    val daily: Double? = 0.0,
                    @SerializedName("hasRDI")
                    val hasRDI: Boolean? = false,
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("schemaOrgTag")
                    val schemaOrgTag: String? = "",
                    @SerializedName("tag")
                    val tag: String? = "",
                    @SerializedName("total")
                    val total: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )
            }

            data class Images(
                @SerializedName("LARGE")
                val lARGE: LARGE? = LARGE(),
                @SerializedName("REGULAR")
                val rEGULAR: REGULAR? = REGULAR(),
                @SerializedName("SMALL")
                val sMALL: SMALL? = SMALL(),
                @SerializedName("THUMBNAIL")
                val tHUMBNAIL: THUMBNAIL? = THUMBNAIL()
            ) {
                data class LARGE(
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )

                data class REGULAR(
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )

                data class SMALL(
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )

                data class THUMBNAIL(
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )
            }

            data class Ingredient(
                @SerializedName("food")
                val food: String? = "",
                @SerializedName("foodCategory")
                val foodCategory: String? = "",
                @SerializedName("foodId")
                val foodId: String? = "",
                @SerializedName("image")
                val image: String? = "",
                @SerializedName("measure")
                val measure: String? = "",
                @SerializedName("quantity")
                val quantity: Double? = 0.0,
                @SerializedName("text")
                val text: String? = "",
                @SerializedName("weight")
                val weight: Double? = 0.0
            )

            data class TotalDaily(
                @SerializedName("CA")
                val cA: CA? = CA(),
                @SerializedName("CHOCDF")
                val cHOCDF: CHOCDF? = CHOCDF(),
                @SerializedName("CHOLE")
                val cHOLE: CHOLE? = CHOLE(),
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: ENERCKCAL? = ENERCKCAL(),
                @SerializedName("FASAT")
                val fASAT: FASAT? = FASAT(),
                @SerializedName("FAT")
                val fAT: FAT? = FAT(),
                @SerializedName("FE")
                val fE: FE? = FE(),
                @SerializedName("FIBTG")
                val fIBTG: FIBTG? = FIBTG(),
                @SerializedName("FOLDFE")
                val fOLDFE: FOLDFE? = FOLDFE(),
                @SerializedName("K")
                val k: K? = K(),
                @SerializedName("MG")
                val mG: MG? = MG(),
                @SerializedName("NA")
                val nA: NA? = NA(),
                @SerializedName("NIA")
                val nIA: NIA? = NIA(),
                @SerializedName("P")
                val p: P? = P(),
                @SerializedName("PROCNT")
                val pROCNT: PROCNT? = PROCNT(),
                @SerializedName("RIBF")
                val rIBF: RIBF? = RIBF(),
                @SerializedName("THIA")
                val tHIA: THIA? = THIA(),
                @SerializedName("TOCPHA")
                val tOCPHA: TOCPHA? = TOCPHA(),
                @SerializedName("VITA_RAE")
                val vITARAE: VITARAE? = VITARAE(),
                @SerializedName("VITB12")
                val vITB12: VITB12? = VITB12(),
                @SerializedName("VITB6A")
                val vITB6A: VITB6A? = VITB6A(),
                @SerializedName("VITC")
                val vITC: VITC? = VITC(),
                @SerializedName("VITD")
                val vITD: VITD? = VITD(),
                @SerializedName("VITK1")
                val vITK1: VITK1? = VITK1(),
                @SerializedName("ZN")
                val zN: ZN? = ZN()
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class K(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class MG(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class NA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class P(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )
            }

            data class TotalNutrients(
                @SerializedName("CA")
                val cA: CA? = CA(),
                @SerializedName("CHOCDF")
                val cHOCDF: CHOCDF? = CHOCDF(),
                @SerializedName("CHOCDF.net")
                val cHOCDFNet: CHOCDFNet? = CHOCDFNet(),
                @SerializedName("CHOLE")
                val cHOLE: CHOLE? = CHOLE(),
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: ENERCKCAL? = ENERCKCAL(),
                @SerializedName("FAMS")
                val fAMS: FAMS? = FAMS(),
                @SerializedName("FAPU")
                val fAPU: FAPU? = FAPU(),
                @SerializedName("FASAT")
                val fASAT: FASAT? = FASAT(),
                @SerializedName("FAT")
                val fAT: FAT? = FAT(),
                @SerializedName("FATRN")
                val fATRN: FATRN? = FATRN(),
                @SerializedName("FE")
                val fE: FE? = FE(),
                @SerializedName("FIBTG")
                val fIBTG: FIBTG? = FIBTG(),
                @SerializedName("FOLAC")
                val fOLAC: FOLAC? = FOLAC(),
                @SerializedName("FOLDFE")
                val fOLDFE: FOLDFE? = FOLDFE(),
                @SerializedName("FOLFD")
                val fOLFD: FOLFD? = FOLFD(),
                @SerializedName("K")
                val k: K? = K(),
                @SerializedName("MG")
                val mG: MG? = MG(),
                @SerializedName("NA")
                val nA: NA? = NA(),
                @SerializedName("NIA")
                val nIA: NIA? = NIA(),
                @SerializedName("P")
                val p: P? = P(),
                @SerializedName("PROCNT")
                val pROCNT: PROCNT? = PROCNT(),
                @SerializedName("RIBF")
                val rIBF: RIBF? = RIBF(),
                @SerializedName("SUGAR")
                val sUGAR: SUGAR? = SUGAR(),
                @SerializedName("SUGAR.added")
                val sUGARAdded: SUGARAdded? = SUGARAdded(),
                @SerializedName("THIA")
                val tHIA: THIA? = THIA(),
                @SerializedName("TOCPHA")
                val tOCPHA: TOCPHA? = TOCPHA(),
                @SerializedName("VITA_RAE")
                val vITARAE: VITARAE? = VITARAE(),
                @SerializedName("VITB12")
                val vITB12: VITB12? = VITB12(),
                @SerializedName("VITB6A")
                val vITB6A: VITB6A? = VITB6A(),
                @SerializedName("VITC")
                val vITC: VITC? = VITC(),
                @SerializedName("VITD")
                val vITD: VITD? = VITD(),
                @SerializedName("VITK1")
                val vITK1: VITK1? = VITK1(),
                @SerializedName("WATER")
                val wATER: WATER? = WATER(),
                @SerializedName("ZN")
                val zN: ZN? = ZN()
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class CHOCDFNet(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FAMS(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FAPU(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FATRN(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FOLAC(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class FOLFD(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class K(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class MG(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class NA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class P(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class SUGAR(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class SUGARAdded(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class WATER(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String? = "",
                    @SerializedName("quantity")
                    val quantity: Double? = 0.0,
                    @SerializedName("unit")
                    val unit: String? = ""
                )
            }
        }
    }

    data class Links(
        @SerializedName("next")
        val next: Next? = Next()
    ) {
        data class Next(
            @SerializedName("href")
            val href: String? = "",
            @SerializedName("title")
            val title: String? = ""
        )
    }
}