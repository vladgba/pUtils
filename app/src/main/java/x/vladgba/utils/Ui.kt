package x.vladgba.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import java.util.Locale

/** A tool page hosted by [MainActivity]. Sensors are only active between start() and stop(). */
interface Screen {
    val view: View
    fun start()
    fun stop()
}

object Ui {
    /** Locale-independent formatting (dot decimals, copy-paste safe). */
    fun f(fmt: String, vararg args: Any?): String = String.format(Locale.US, fmt, *args)

    // Suite (pUI) palette, loaded from the p_* tokens by MainActivity so it follows light/dark mode.
    var BG = Color.rgb(0x12, 0x14, 0x18); private set
    var PANEL = Color.rgb(0x1C, 0x1F, 0x26); private set
    var FG = Color.rgb(0xEC, 0xED, 0xF1); private set
    var DIM = Color.rgb(0xA3, 0xA7, 0xB3); private set
    var GRID = Color.rgb(0x2E, 0x33, 0x3D); private set
    var ACCENT = Color.rgb(0x8B, 0x5C, 0xF6); private set
    var ACCENT_SOFT = Color.rgb(0x2D, 0x25, 0x47); private set
    var ON_ACCENT_SOFT = Color.rgb(0xDD, 0xD0, 0xFF); private set
    var RED = Color.rgb(0xFF, 0x8A, 0x80); private set
    var GREEN = Color.rgb(0x5C, 0xD3, 0x9B); private set
    var AMBER = Color.rgb(0xFF, 0xC2, 0x66); private set

    fun load(ctx: Context) {
        BG = ctx.getColor(R.color.p_bg)
        PANEL = ctx.getColor(R.color.p_surface)
        FG = ctx.getColor(R.color.p_text)
        DIM = ctx.getColor(R.color.p_text2)
        GRID = ctx.getColor(R.color.p_line)
        ACCENT = ctx.getColor(R.color.p_accent)
        ACCENT_SOFT = ctx.getColor(R.color.p_accent_soft)
        ON_ACCENT_SOFT = ctx.getColor(R.color.p_on_accent_soft)
        RED = ctx.getColor(R.color.p_danger)
        GREEN = ctx.getColor(R.color.p_success)
        AMBER = ctx.getColor(R.color.p_warning)
    }

    fun alpha(color: Int, a: Int) = (color and 0x00FFFFFF) or (a shl 24)

    fun dp(ctx: Context, v: Float): Float = v * ctx.resources.displayMetrics.density
    fun sp(ctx: Context, v: Float): Float = v * ctx.resources.displayMetrics.scaledDensity

    fun fill(color: Int) = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color
        style = Paint.Style.FILL
    }

    fun stroke(color: Int, width: Float) = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color
        style = Paint.Style.STROKE
        strokeWidth = width
        strokeCap = Paint.Cap.ROUND
    }

    fun text(color: Int, size: Float, bold: Boolean = false, align: Paint.Align = Paint.Align.CENTER) =
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            this.color = color
            textSize = size
            textAlign = align
            typeface = if (bold) Typeface.create(Typeface.DEFAULT, Typeface.BOLD) else Typeface.DEFAULT
        }

    fun mono(color: Int, size: Float, align: Paint.Align = Paint.Align.LEFT) =
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            this.color = color
            textSize = size
            textAlign = align
            typeface = Typeface.MONOSPACE
        }

    private val CARDINALS = arrayOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
    fun cardinal(deg: Float): String = CARDINALS[(((deg % 360f + 360f) % 360f + 22.5f) / 45f).toInt() % 8]

    /** Shortest signed difference b - a in degrees, in (-180, 180]. */
    fun angleDiff(a: Float, b: Float): Float {
        var d = (b - a) % 360f
        if (d > 180f) d -= 360f
        if (d <= -180f) d += 360f
        return d
    }
}
