package camp_system.user;

public enum Faculty {
    NBS, CCEB, EEE, CEE, MSE, SCSE, MAE, ADM, SOH, SSS, WKWSCI, SPMS, SBS, ASE, LKC, GC, NIE, RSIS, NTU;

    public String toString() {
        switch (this) {
            case NBS: return "NBS"; 
            case CCEB: return "CCEB"; 
            case EEE: return "EEE"; 
            case CEE: return "CEE"; 
            case MSE: return "MSE"; 
            case SCSE: return "SCSE"; 
            case MAE: return "MAE"; 
            case ADM: return "ADM"; 
            case SOH: return "SOH"; 
            case SSS: return "SSS"; 
            case WKWSCI: return "WKWSCI"; 
            case SPMS: return "SPMS"; 
            case SBS: return "SBS"; 
            case ASE: return "ASE"; 
            case LKC: return "LKC"; 
            case GC: return "GC"; 
            case NIE: return "NIE"; 
            case RSIS: return "RSIS"; 
            case NTU: return "NTU";
            default: return null;
        }
    }

    public static Faculty fromString(String faculty) {
        switch (faculty.toUpperCase()) {
            case "NBS": return NBS; 
            case "CCEB": return CCEB; 
            case "EEE": return EEE; 
            case "CEE": return CEE; 
            case "MSE": return MSE; 
            case "SCSE": return SCSE; 
            case "MAE": return MAE; 
            case "ADM": return ADM; 
            case "SOH": return SOH; 
            case "SSS": return SSS; 
            case "WKWSCI": return WKWSCI; 
            case "SPMS": return SPMS; 
            case "SBS": return SBS; 
            case "ASE": return ASE; 
            case "LKC": return LKC; 
            case "GC": return GC; 
            case "NIE": return NIE; 
            case "RSIS": return RSIS; 
            case "NTU" : return NTU;
            default: return null;
        }
    }
}
