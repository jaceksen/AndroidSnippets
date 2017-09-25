    //access to permsions
    void checkUserPermsions(){
        if ( Build.VERSION.SDK_INT >= 23){
            if (
                    (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) !=
                    PackageManager.PERMISSION_GRANTED)
                    && (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) !=
                            PackageManager.PERMISSION_GRANTED)
                    ){
                requestPermissions(new String[]{
                                Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_SMS},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

    }
    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    // Permission Denied
                    Toast.makeText( this,"NIE MA DOSTĘPU DO SMSów" , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
