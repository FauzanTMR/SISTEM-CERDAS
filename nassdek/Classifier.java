package com.darskhandev.nassdek;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/darskhandev/nassdek/Classifier;", "", "()V", "classify", "Lcom/darskhandev/nassdek/Order;", "image", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Ljava/io/File;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Classifier.kt */
public final class Classifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ImageClassifierHelper";
    /* access modifiers changed from: private */
    public static final Map<String, Integer> labelsWithPrice = MapsKt.mapOf(TuplesKt.to("nasi", 10000), TuplesKt.to("sayur", 0), TuplesKt.to("sambal", 0), TuplesKt.to("ayam goreng", 17000), TuplesKt.to("ayam bakar", 17000), TuplesKt.to("ayam gulai", 17000), TuplesKt.to("daging rendang", Integer.valueOf(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH)), TuplesKt.to("ikan goreng", 12000), TuplesKt.to("ikan gulai", 10000), TuplesKt.to("perkadel", 8000), TuplesKt.to("telur bulat", 8000), TuplesKt.to("telur dadar", 12000));

    public final Object classify(File file, Context context, Continuation<? super Order> continuation) {
        InputStream open = context.getAssets().open("modelmultilabepadang3.tflite");
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(open.available());
        allocateDirect.put(ByteStreamsKt.readBytes(open));
        Interpreter interpreter = new Interpreter(allocateDirect);
        TensorBuffer createFixedSize = TensorBuffer.createFixedSize(new int[]{1, 256, 256, 3}, DataType.FLOAT32);
        Intrinsics.checkNotNullExpressionValue(createFixedSize, "createFixedSize(...)");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()).copy(Bitmap.Config.ARGB_8888, true), 256, 256, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(786432);
        allocateDirect2.order(ByteOrder.nativeOrder());
        for (int i = 0; i < 256; i++) {
            for (int i2 = 0; i2 < 256; i2++) {
                int pixel = createScaledBitmap.getPixel(i2, i);
                allocateDirect2.putFloat(((float) Color.red(pixel)) / 255.0f);
                allocateDirect2.putFloat(((float) Color.green(pixel)) / 255.0f);
                allocateDirect2.putFloat(((float) Color.blue(pixel)) / 255.0f);
            }
        }
        createFixedSize.loadBuffer(allocateDirect2);
        TensorBuffer createFixedSize2 = TensorBuffer.createFixedSize(new int[]{1, 12}, DataType.FLOAT32);
        Intrinsics.checkNotNullExpressionValue(createFixedSize2, "createFixedSize(...)");
        interpreter.run(createFixedSize.getBuffer(), createFixedSize2.getBuffer());
        float[] floatArray = createFixedSize2.getFloatArray();
        StringBuilder sb = new StringBuilder("classify: ");
        Intrinsics.checkNotNull(floatArray);
        Log.d(TAG, sb.append(ArraysKt.asList(floatArray)).toString());
        List arrayList = new ArrayList();
        int length = floatArray.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (((double) floatArray[i4]) >= 0.8d) {
                Map<String, Integer> map = labelsWithPrice;
                arrayList.add(CollectionsKt.toList(map.keySet()).get(i4));
                i3 += ((Number) CollectionsKt.toList(map.values()).get(i4)).intValue();
            }
        }
        Log.d(TAG, "classify: " + arrayList);
        return new Order(arrayList, i3);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/darskhandev/nassdek/Classifier$Companion;", "", "()V", "TAG", "", "labelsWithPrice", "", "", "getLabelsWithPrice", "()Ljava/util/Map;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Classifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Integer> getLabelsWithPrice() {
            return Classifier.labelsWithPrice;
        }
    }
}
