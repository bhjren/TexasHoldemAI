
/**
 * 保存preflop决策需要的表
 * @author jenson
 *
 */
class PreflopData {
	/* BaseIncrement表以及相关索引 */
	public static final int BI_TIGHT = 0, BI_MODERATE = 1,	BI_LOOSE = 2;
	public static final int TWO_PLAYER = 0, THREEORFOUR_PLAYER = 1,
			FIVEPLUS_PLAYER = 2;
	public static final int Make1 = 0, Make2 = 1, Make4 = 2;
	
	public static final int[] getBaseIncrement(int group, int make, int tightness)
	{
		int res[] = new int[2];
		if(group == TWO_PLAYER) {
			switch(make){
			case Make1:
				res[0] = -50;
				res[1] = 50;
				break;
			case Make2:
				if(tightness == BI_TIGHT){
					res[0] = 150;
					res[1] = 50;
				}else if(tightness == BI_MODERATE){
					res[0] = 50;
					res[1] = 50;
				}else{
					res[0] = 0;
					res[1] = 0;
				}
				break;
			case Make4:
				res[0] = 300;
				res[1] = 300;
				break;
			}
		}else if(group == THREEORFOUR_PLAYER){
			switch(make){
			case Make1:
				if(tightness == BI_TIGHT){
					res[0] = 50;
					res[1] = 50;
				}else if(tightness == BI_MODERATE){
					res[0] = 50;
					res[1] = 25;
				}else{
					res[0] = 50;
					res[1] = 10;
				}
				break;
			case Make2:
				if(tightness == BI_TIGHT){
					res[0] = 200;
					res[1] = 50;
				}else if(tightness == BI_MODERATE){
					res[0] = 200;
					res[1] = 25;
				}else{
					res[0] = 200;
					res[1] = 10;
				}
				break;
			case Make4:
				res[0] = 580;
				res[1] = 0;
				break;
			}
		}else{
			switch(make){
			case Make1:
				if(tightness == BI_TIGHT){
					res[0] = 0;
					res[1] = 70;
				}else if(tightness == BI_MODERATE){
					res[0] = 0;
					res[1] = 50;
				}else{
					res[0] = 0;
					res[1] = 30;
				}
				break;
			case Make2:
				if(tightness == BI_TIGHT){
					res[0] = 450;
					res[1] = 50;
				}else if(tightness == BI_MODERATE){
					res[0] = 450;
					res[1] = 25;
				}else{
					res[0] = 450;
					res[1] = 10;
				}
				break;
			case Make4:
				res[0] = 900;
				res[1] = 0;
				break;
			}
		}
		return res;
	}
	
	public static final int SortIR7[] = {
		-495, -469, -462, -459, -447, -433, -422, -418, -414, -397, -391, -383, -365, -362, -356, -347, -336, -334, -323, -309, -308, 
		-304, -303, -287, -274, -273, -270, -259, -248, -235, -230, -227, -223, -217, -208, -204, -200, -198, -188, -184, -180, 
		-175, -174, -164, -164, -163, -151, -148, -146, -135, -133, -128, -128, -124, -121, -112, -111, -106, -103, -95, -88, 
		-87, -83, -72, -69, -68, -47, -46, -39, -38, -38, -29, -26, -26, -15, -10, -10, -10, -6, -5, -1, 
		1, 2, 6, 21, 22, 23, 30, 31, 32, 35, 35, 49, 51, 59, 64, 64, 64, 67, 72, 72, 
		93, 99, 108, 117, 118, 118, 122, 126, 127, 134, 141, 147, 151, 153, 155, 162, 167, 168, 189, 190, 
		206, 223, 245, 256, 261, 268, 268, 269, 298, 299, 304, 304, 305, 313, 333, 336, 363, 365, 373, 377, 
		380, 383, 384, 416, 420, 420, 423, 462, 475, 529, 536, 553, 565, 574, 591, 628, 644, 669, 712, 720, 
		764, 765, 815, 934, 996, 1279, 1621, 2043
	};
	
	/** income rate  */
	public static final int IR2[][] = {
		{7, -351, -334, -314,-318,-308,-264,-217, -166, -113, -53, 10, 98},
		{-279, 74, -296, -274, -277,  -267, -251, -201, -148, -93, -35, 27, 116},
		{-263, -225, 142, -236, -240, -231, -209, -185, -130, -75, -17, 46, 134},
		{-244, -206, -169, 207	-201, -189, -169, -148, -114, -55, 2, 68, 153},
		{-247, -208, -171, -138, 264, -153, -134, -108, -78, -43, 19, 85, 154},
		{-236, -200, -162, -125, -91, 324, -99, -72, -43, -6, 37, 104, 176},
		{-192, -182, -143, -108, -75, -43, 384, -39, -4, 29, 72, 120, 197},
		{-152, -134, -122, -84, -50	-17, 16, 440, 28, 65, 106, 155, 215},
		{-104, -86, -69, -56, -19, 12, 47, 81, 499, 102, 146, 195, 254},
		{-52, -35, -19, 0, 11, 46, 79, 113, 149, 549, 161, 212, 271},
		{2, 21, 34, 55, 72, 86, 121, 153, 188, 204, 598, 228, 289},
		{63, 79, 98, 116, 132, 151, 168, 200, 235, 249, 268, 647, 305},
		{146, 164, 180, 198, 198, 220, 240, 257, 291, 305, 323, 339, 704},
	};
	
	public static final int IR4[][] = {
		{-121, -440, -409, -382, -411, -432, -394, -357, -301, -259, -194, -116, 16},
		{-271, -42, -345, -312, -340, -358, -371, -328, -277	, -231, -165, -87, 54},
		{-245, 	-183, 	52	, -246	, -269, 	-287, 	-300	, -308, 	-252, 	-204	, -135, -55	, 84},
		{-219, 	-151, -91, 	152	, -200	, -211	, -227, 	-236, 	-227, -169	, -104,-24, 118},
		{-247, -177, 	-113, 	-52, 256, 	-145, 	-152, 	-158, 	-152, 	-145, 	-74	,9, 99},
		{-261, 	-201, 	-129, 	-65, 	3, 	376, 	-76	, -79, 	-68	, -66, 	-44, 	48, 	148},
		{-226, 	-204, 	-140, 	-73, 	-2, 	66, 	503, 	0, 	15, 	24, 	45, 	84	, 194},
		{-191, 	-166, 	-147, 	-79, 	-5, 	68, 	138, 	647, 	104, 	113	, 136, 	177	, 241},
		{-141, 	-116, 	-91, 	-69, 	-4, 	75, 	150, 	235, 	806	, 226	, 255, 	295, 	354},
		{-89, 	-67	, -41, 	-12, 	7, 	82, 	163	, 248, 	349, 	965, 	301	, 348,	410},
		{-29, 	-3, 	22, 51, 	80, 	108	, 185	, 274, 	379, 	423, 	1141, 	403, 	473},
		{47	, 76, 	101	, 128, 	161	, 199, 	230, 	318	, 425, 	473	, 529	, 1325, 	541},
		{175, 211	, 237, 	266, 249, 	295	, 338, 	381	, 491, 	539	, 594, 	655	, 1554},
	};
	
	public static final int IR7[][] = {
			{-6,	-462,	-422,	-397,	-459,	-495,	-469,	-433,	-383,	-336,	-274,	-188,	-39},
			{-180,	21,	-347,	-304,	-365,	-418,	-447,	-414,	-356,	-308,	-248,	-163,	-1},
			{-148,	-69,	67,	-227,	-273,	-323,	-362,	-391,	-334,	-287,	-223,	-133,	32},
			{-121,	-38,	31,	122,	-198,	-230,	-270,	-303,	-309,	-259,	-200,	-103,	64},
			{-174,	-95,	-10,	64,	206,	-151,	-175,	-204,	-217,	-235,	-164,	-72	,23},
			{-208,	-135,	-47	,35,	108,	298	,-87	,-106	,-112,	-128,	-124	,-26,	72},
			{-184,	-164,	-83,	2,	93,	168,	420,	-5	,6	,-10	,-10,	22,	126},
			{-146,	-128,	-111,	-26	,64,	153,	245,	565,	134	,118,	118,	151	,189},
			{-88,	-68,	-46,	-29,	59	,155,	268,	383,	765	,299,	305	,336, 373},
			{-38,	-15,	1,	30,	51,	147,	256,	377,	536,	996	,380,	420	,462},
			{35,	49,	72,	99,	127,	162,	268,	384,	553,	628	,1279,	529	,574},
			{117,	141,	167,	190,	223	,261,	304,	423	,591	,669,	764,	1621,	712},
			{269,	304,	333,	363,	313	,365,	416	,475,	644,	720	,815,	934	, 2043},
	};
}
